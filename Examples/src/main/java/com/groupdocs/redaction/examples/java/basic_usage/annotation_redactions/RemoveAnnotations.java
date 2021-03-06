package com.groupdocs.redaction.examples.java.basic_usage.annotation_redactions;

import com.groupdocs.redaction.examples.java.Constants;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.options.SaveOptions;
import com.groupdocs.redaction.redactions.DeleteAnnotationRedaction;


/**
 * <p>
 * The following example demonstrates how to remove only specific annotations using regular expression
 * </p>
 */
public class RemoveAnnotations
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor  = new Redactor(Constants.ANNOTATED_XLSX);
        try 
        {
            // Delete all annotations, matching these criteria
            redactor.apply(new DeleteAnnotationRedaction("(?im:(use|show|describe))"));
            SaveOptions tmp0 = new  SaveOptions();
            tmp0.setAddSuffix(true);
            tmp0.setRasterizeToPDF(false);
            // Save the document to "*_Redacted.*" file in original format
            redactor.save(tmp0);
        }
        finally { redactor.close(); }
    }
}

