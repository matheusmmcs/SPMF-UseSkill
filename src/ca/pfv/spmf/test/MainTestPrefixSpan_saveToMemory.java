package ca.pfv.spmf.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.List;

import ca.pfv.spmf.algorithms.sequentialpatterns.BIDE_and_prefixspan.AlgoPrefixSpan;
import ca.pfv.spmf.algorithms.sequentialpatterns.BIDE_and_prefixspan.SequentialPattern;
import ca.pfv.spmf.algorithms.sequentialpatterns.BIDE_and_prefixspan.SequentialPatterns;
import ca.pfv.spmf.input.sequence_database_list_integers.SequenceDatabase;


/**
 * Example of how to use the PrefixSpan algorithm in source code.
 * @author Philippe Fournier-Viger
 */
public class MainTestPrefixSpan_saveToMemory {
	
	public static void main(String [] arg) throws IOException{    
		// Load a sequence database
		SequenceDatabase sequenceDatabase = new SequenceDatabase(); 
		
		// From File
		//sequenceDatabase.loadFile(fileToPath("useskill_prefixspanTest.txt"));
		
		// From String
		String teste = "1 -1 2 -1 3 -1 4 -1 5 -1 6 -1 7 -1 8 -1 9 -1 10 -1 11 -1 12 -1 13 -1 14 -1 15 -1 14 -1 16 -1 17 -1 18 -1 14 -1 19 -1 14 -1 20 -1 14 -1 -2\n";
		teste += "1 -1 2 -1 3 -1 4 -1 5 -1 6 -1 7 -1 8 -1 11 -1 10 -1 12 -1 14 -1 15 -1 14 -1 21 -1 22 -1 23 -1 23 -1 24 -1 24 -1 1 -1 -2\n";
		teste += "1 -1 2 -1 3 -1 4 -1 5 -1 6 -1 7 -1 8 -1 10 -1 11 -1 10 -1 11 -1 12 -1 14 -1 -2\n";
		teste += "1 -1 2 -1 3 -1 4 -1 5 -1 6 -1 7 -1 8 -1 14 -1 -2\n";
		teste += "1 -1 2 -1 3 -1 4 -1 31 -1 32 -1 33 -1 34 -1 5 -1 6 -1 7 -1 8 -1 10 -1 11 -1 8 -1 14 -1 -2\n";
		teste += "1 -1 23 -1 2 -1 3 -1 4 -1 31 -1 32 -1 5 -1 6 -1 7 -1 8 -1 10 -1 11 -1 12 -1 35 -1 8 -1 36 -1 37 -1 10 -1 11 -1 12 -1 38 -1 27 -1 28 -1 29 -1 39 -1 -2\n";
		teste += "1 -1 2 -1 3 -1 4 -1 5 -1 6 -1 7 -1 8 -1 10 -1 11 -1 12 -1 25 -1 26 -1 27 -1 28 -1 29 -1 30 -1 -2\n";
		teste += "1 -1 3 -1 2 -1 4 -1 5 -1 7 -1 6 -1 4 -1 5 -1 6 -1 7 -1 4 -1 31 -1 32 -1 5 -1 6 -1 7 -1 8 -1 10 -1 11 -1 12 -1 25 -1 26 -1 27 -1 28 -1 29 -1 30 -1 -2";
		
		sequenceDatabase.loadFromString(teste, "\n");
		
		
		// print the database to console
		sequenceDatabase.print();
		
		// Create an instance of the algorithm 
		AlgoPrefixSpan algo = new AlgoPrefixSpan(); 
		//algo.setMaximumPatternLength(3);
		
		// execute the algorithm with minsup = 50 %
		SequentialPatterns patterns = algo.runAlgorithm(sequenceDatabase, 1, null);    
		algo.printStatistics(sequenceDatabase.size());
		
		System.out.println(" == PATTERNS ==");
		for(List<SequentialPattern> level : patterns.levels) {
			for(SequentialPattern pattern : level){
				System.out.println(pattern + " support : " + pattern.getAbsoluteSupport());
			}
		}
	}
	
	public static String fileToPath(String filename) throws UnsupportedEncodingException{
		URL url = MainTestPrefixSpan_saveToMemory.class.getResource(filename);
		 return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
	}
}