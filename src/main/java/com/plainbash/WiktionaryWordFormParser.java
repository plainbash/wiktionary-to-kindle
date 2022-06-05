package com.plainbash;

import edu.self.w2k.util.WiktionaryUtil;

import java.util.logging.Logger;

public class WiktionaryWordFormParser {
    private final static Logger LOG = Logger.getLogger(WiktionaryWordFormParser.class.getName());

    public String format(String entry) {
        try {
            if (entry.contains("{{") && entry.contains("}}") && entry.contains("-form of")) {
                WordForm wordForm = new WordForm(entry.substring(2, entry.lastIndexOf("}}")).split("\\|"));
                if (wordForm.isValid()) {
                    return String.format("<i>%s form of <a href=\"dictionary-fi-en-%s-%s.html#%s\">%s</a></i>",
                            wordForm.getDescription(),
                            (int)wordForm.getInfinitiveForm().charAt(0),
                            wordForm.getInfinitiveForm().length()>= 2 ? (int)wordForm.getInfinitiveForm().charAt(1) : "",
                            wordForm.getInfinitiveForm(),
                            wordForm.getInfinitiveForm());
                }
            }
        }
        catch (Exception e) {
            LOG.warning("Exception caught for entry" + entry + " with error " + e);
        }

        return entry;
    }
}
