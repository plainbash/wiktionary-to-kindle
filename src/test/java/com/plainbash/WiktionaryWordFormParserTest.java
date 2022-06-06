package com.plainbash;

import org.junit.Assert;
import org.junit.Test;

public class WiktionaryWordFormParserTest {
    @Test
    public void validString_thenParse() {
        final String shortDescription = "{{fi-form of|case=adessive|saada|pr=third-person|pl=singular|mood=indicative|tense=present|suffix=-pas}}";
        final String longDescription = "{{fi-form of|saada|pr=second-person|pl=singular|mood=imperative|tense=present connegative|suffix=-pas}}";
//        final String inflectionForm = "{{inflection of|fi|byrokratisoituminen||par|s}}";
//        final String infinitiveForm = "{{fi-infinitive of|t=4|c=par|byrokratisoitua}}";
//        final String verbForm = "{{fi-verb form of|tm=potn|c=1|byrokratisoitua}}";
//        final String participleForm = "{{fi-participle of|t=past|byrokratisoitua|plural=true}}";

        WiktionaryWordFormParser parser = new WiktionaryWordFormParser();

        Assert.assertEquals("Invalid string", "<i>fi-form of|case=adessive|pr=third-person|pl=singular|mood=indicative|tense=present|suffix=-pas form of <a href=\"dictionary-fi-en-115-097.html#saada\">saada</a></i>", parser.format(shortDescription));
        Assert.assertEquals("Invalid string", "<i>fi-form of|pr=second-person|pl=singular|mood=imperative|tense=present connegative|suffix=-pas form of <a href=\"dictionary-fi-en-115-097.html#saada\">saada</a></i>", parser.format(longDescription));
//        Assert.assertEquals("Invalid string", "<i>pr=second-person|pl=singular|mood=imperative|tense=present connegative|suffix=-pas form of <a href=\"dictionary-fi-en-115-97.html#saada\">saada</a></i>", parser.format(inflectionForm));
//        Assert.assertEquals("Invalid string", "<i>pr=second-person|pl=singular|mood=imperative|tense=present connegative|suffix=-pas form of <a href=\"dictionary-fi-en-115-97.html#saada\">saada</a></i>", parser.format(infinitiveForm));
//        Assert.assertEquals("Invalid string", "<i>pr=second-person|pl=singular|mood=imperative|tense=present connegative|suffix=-pas form of <a href=\"dictionary-fi-en-115-97.html#saada\">saada</a></i>", parser.format(verbForm));
//        Assert.assertEquals("Invalid string", "<i>pr=second-person|pl=singular|mood=imperative|tense=present connegative|suffix=-pas form of <a href=\"dictionary-fi-en-115-97.html#saada\">saada</a></i>", parser.format(participleForm));
    }

    @Test
    public void validString_shortKey_thenParse() {
        final String shortDescription = "{{fi-form of|case=adessive|s|pr=third-person|pl=singular|mood=indicative|tense=present|suffix=-pas}}";

        WiktionaryWordFormParser parser = new WiktionaryWordFormParser();

        Assert.assertEquals("Invalid string", "<i>fi-form of|case=adessive|pr=third-person|pl=singular|mood=indicative|tense=present|suffix=-pas form of <a href=\"dictionary-fi-en-115-.html#s\">s</a></i>", parser.format(shortDescription));
    }

    @Test
    public void stringWithEmptyField_thenParse() {
        final String description = "{{fi-form of|asia|case=translative||pl=plural}}";

        WiktionaryWordFormParser parser = new WiktionaryWordFormParser();

        Assert.assertEquals("Invalid string", "<i>fi-form of|case=translative|pl=plural form of <a href=\"dictionary-fi-en-097-115.html#asia\">asia</a></i>", parser.format(description));
    }

    @Test
    public void invalidString_thenParse() {
        final String description = "{{fi-form of|case=illative|pl=singular|vuori}} (1) =into the mountain";

        WiktionaryWordFormParser parser = new WiktionaryWordFormParser();

        Assert.assertEquals("Invalid string", "<i>fi-form of|case=illative|pl=singular form of <a href=\"dictionary-fi-en-118-117.html#vuori\">vuori</a></i>", parser.format(description));
    }
}
