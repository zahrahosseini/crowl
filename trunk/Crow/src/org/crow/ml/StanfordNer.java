/**
 * 
 */
package org.crow.ml;

import edu.stanford.nlp.ie.AbstractSequenceClassifier;
import edu.stanford.nlp.ie.crf.CRFClassifier;

/**
 * @author viksin
 *
 */
public class StanfordNer {
	
	public void identifyNE(String text)
	{
		 String serializedClassifier = "../classifiers/ner-eng-ie.crf-3-all2008.ser.gz";
		 AbstractSequenceClassifier classifier = CRFClassifier.getClassifierNoExceptions(serializedClassifier);
		 String s1 = text;//"Good afternoon Rajat Raina, how are you today?";
	     String s2 = "I go to school at Stanford University, which is located in California.";
	     System.out.println(classifier.classifyToString(s1));
	     System.out.println(classifier.classifyWithInlineXML(s1));
	     System.out.println(classifier.classifyToString(s2, "xml", true));
	}
}
