package com.groupdocs.redaction.examples.java.advanced_usage;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.configuration.DocumentFormatConfiguration;
import com.groupdocs.redaction.integration.DocumentFormatInstance;
import com.groupdocs.redaction.options.SaveOptions;
import com.groupdocs.redaction.redactions.ExactPhraseRedaction;
import com.groupdocs.redaction.redactions.ReplacementOptions;

import com.groupdocs.redaction.examples.java.helper_classes.PlainTextDocument;
import com.groupdocs.redaction.examples.java.Constants;

/**
 * <p>
 * The following example demonstrates how to register and use custom format handler for plain text documents
 * </p>
 */
public class CreateCustomFormatHandler
{
    public static void run() throws java.lang.Exception
    {
        DocumentFormatConfiguration config = new DocumentFormatConfiguration();
        config.setExtensionFilter(".txt");
        config.setDocumentType(PlainTextDocument.class);
        DocumentFormatInstance.getDefaultConfiguration().getAvailableFormats().add(config);
        final Redactor redactor = new Redactor(Constants.SAMPLE_TXT);
        try 
        {
            // Here we can use document instance to perform redactions
            redactor.apply(new ExactPhraseRedaction("John Doe", new ReplacementOptions("[personal]")));
            // Save the document to "*_AnyText.*" (e.g. timestamp instead of "AnyText") in its file name without rasterization
            redactor.save(new SaveOptions(false, "AnyText"));
        }
        finally { redactor.close(); }
    }
}
 

