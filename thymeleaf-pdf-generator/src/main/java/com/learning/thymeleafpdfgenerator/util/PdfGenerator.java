package com.learning.thymeleafpdfgenerator.util;

import com.lowagie.text.DocumentException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class PdfGenerator {

    private final TemplateEngine templateEngine;

    public byte[] generatePdf(String htmlContent, Context context) {
        try {
            // Process Thymeleaf template using the HTML string
            String processedHtmlContent = templateEngine.process(htmlContent, context);

            try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
                ITextRenderer renderer = new ITextRenderer();
                renderer.setDocumentFromString(processedHtmlContent);
                renderer.layout();
                renderer.createPDF(outputStream);
                return outputStream.toByteArray();
            }
        } catch (IOException | DocumentException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to generate PDF", e);
        }
    }
}
