package ProjectTwo;

import java.io.*;

class Project2 {
        public static boolean IsAValidDouble (String s) {
                try {
                        Double.parseDouble(s);
                        return true;
                }
                catch (NumberFormatException nfe) {
                        return false;
                }
        }
        
        public static void main (String args[]) {
            int numLines = 0;
            int validLines = 0;
            int skippedLines = 0;
            double runningTotal = 0.0;
            Double minVal = 0.0;
            Double maxVal = 0.0;

            if (args.length < 1) {
                    System.out.println("Missing Filename");
                    System.out.println("Usage: java Project2 <filename>");
                    return;
            }

            try (
                 FileInputStream fstream = new FileInputStream(args[0]);
                 DataInputStream in = new DataInputStream(fstream);
                 BufferedReader br = new BufferedReader(new InputStreamReader(in));
                ) {
            		String strLine;

            		while ((strLine = br.readLine()) != null) {
            				numLines++;

            				if (IsAValidDouble(strLine) == false) {
                                	skippedLines++;
            				}

            				if (IsAValidDouble(strLine)) {
                                	validLines++;

                                	if (validLines == 1) {
                                        	minVal = Double.parseDouble(strLine);
                                        	maxVal = Double.parseDouble(strLine);
                                	}

                                	runningTotal += Double.parseDouble(strLine);

                                	if (minVal.compareTo(Double.parseDouble(strLine)) > 0) {
                                        	minVal = Double.parseDouble(strLine);
                                	}

                                	if (maxVal.compareTo(Double.parseDouble(strLine)) < 0) {
                                        	maxVal = Double.parseDouble(strLine);
                                	}
            				}
            		}
            }
            catch (FileNotFoundException fnf) {
            		System.out.println("Could not find file " + args[0]);
            		System.out.println("Usage: java Project2 <filename>");
            		return;
            }
            catch (Exception Ex) {
                	System.out.println("Error: " + Ex.toString());
                	return;
            }

            System.out.println("Number of Lines Read: " + numLines);
            System.out.println("Number of Valid Lines: " + validLines);
            System.out.println("Number of Invalid Lines: " + skippedLines);
            System.out.println("Running Total: " + runningTotal);
            System.out.println("Minimum Value: " + minVal);
            System.out.println("Maximum Value: " + maxVal);
       }
}