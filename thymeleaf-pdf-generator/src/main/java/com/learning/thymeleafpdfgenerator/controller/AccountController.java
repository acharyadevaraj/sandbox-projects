package com.learning.thymeleafpdfgenerator.controller;

import com.learning.thymeleafpdfgenerator.util.PdfGenerator;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.thymeleaf.context.Context;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static com.learning.thymeleafpdfgenerator.CustomPdfGeneratorApplication.transactions;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final PdfGenerator pdfGenerator;
    private final ResourceLoader resourceLoader;

    @GetMapping("/generate-pdf")
    public void generateAccountStatementPdf(HttpServletResponse response) {

        try {
            // Load your image from the resource folder or wherever it is stored
            String bankLogoBase64 = loadImage("bank-logo.jpg");

            // Prepare data for the template
            Context context = new Context();
            context.setVariable("transactions", transactions);
            context.setVariable("bankLogo", bankLogoBase64);

            String htmlContent = getHtmlContent("account_statement_template");
            byte[] pdfContent = pdfGenerator.generatePdf(htmlContent, context);

            // Set response headers
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "inline; filename=Transaction Statement.pdf");
            response.setContentLength(pdfContent.length);

            // Write PDF content to response
            response.getOutputStream().write(pdfContent);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to generate PDF", e);

        }
    }

    public String getHtmlContent(String filePath) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:templates/" + filePath + ".html");
        try (InputStream inputStream = resource.getInputStream()) {
            byte[] bytes = FileCopyUtils.copyToByteArray(inputStream);
            return new String(bytes, StandardCharsets.UTF_8);
        }
    }

    public String loadImage(String filePath) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:static/" + filePath);
        InputStream imageStream = resource.getInputStream();
        byte[] imageBytes = imageStream.readAllBytes();

        // Encode the image bytes to Base64
        return Base64.getEncoder().encodeToString(imageBytes);
    }

    @GetMapping("/generate-pdf-base64")
    public ResponseEntity<String> generatePdfWithBase64(HttpServletResponse response) {

        try {
            // Prepare data for the template
            Context context = new Context();
            context.setVariable("transactions", transactions);

            String htmlContent = getHtmlContent("account_statement_template");
            byte[] pdfContent = pdfGenerator.generatePdf(htmlContent, context);

            // Encode PDF content to Base64
            String encodedPdfContent = Base64.getEncoder().encodeToString(pdfContent);

            return ResponseEntity.ok(encodedPdfContent);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to generate PDF", e);
        }
    }
}
