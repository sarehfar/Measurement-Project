import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Scanner;

public class Calculator {
	public static HashSet<String> setClassName=new HashSet<String>();
	public static void main(String[] args) throws IOException {
		ArrayList<ArrayList<String>> records = new ArrayList<>();
		Hashtable<String, Integer> hash=new Hashtable<String, Integer>();
		Scanner input=new Scanner(System.in);
		//"D:\\Measurement-Project\\Reports\\PITest\\commons-codec\\mutations.csv"
		String inputPath=input.nextLine();
		String outputPath=input.nextLine();
		Scanner scan=new Scanner(new FileInputStream(inputPath));
		while(scan.hasNextLine()) {
			records.add(getRecordFromLine(scan.nextLine()));
		}
		int size=0;
		double killed=0;
		int mutation=0;
		for (String item : setClassName) {
			size=0;
			killed=0;
			for (ArrayList<String> arrayList : records) {
				if (item.equalsIgnoreCase(arrayList.get(0))) {
					size++;
					if(arrayList.get(5).equals("KILLED")|| arrayList.get(5).equals("TIMED_OUT") ) {
						killed++;
					}
				}
			}
			mutation=(int) (Math.round(killed/size*100));
			hash.put(item, mutation);
		}
		FileWriter csvWriter = new FileWriter(outputPath);
		hash.entrySet().forEach( entry -> {
			 try {
				csvWriter.append(entry.getKey()+","+entry.getValue());
			} catch (IOException e) {
				e.printStackTrace();
			}
			    try {
					csvWriter.append("\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
		});
		csvWriter.flush();
		csvWriter.close();
	}
	

	public static ArrayList<String> getRecordFromLine(String line) {
	    ArrayList<String> values = new ArrayList<String>();
	    Hashtable<String,Integer> hash=new Hashtable<String,Integer>();
	    try (Scanner rowScanner = new Scanner(line)) {
	        rowScanner.useDelimiter(",");
	        while (rowScanner.hasNext()) {
	            values.add(rowScanner.next());
	        }
	    }
	    setClassName.add(values.get(0));
	    return values;
	}
}
