import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JFileChooser;

import org.json.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonStreamParser;

public class Merge {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		/*
		 * String data = ""; data = new String(Files.readAllBytes(Paths.
		 * get("C:\\Users\\Zach\\Desktop\\Spring 20\\Cloud\\Disqus\\6971761113_20181015141058.txt"
		 * ))); System.out.println(data + "\n\n");
		 * 
		 * JSONObject test = new JSONObject(data);
		 * System.out.println(String.valueOf(data).length() + " " +
		 * String.valueOf(test).length());
		 * 
		 * 
		 * 
		 * InputStream inputStream = new FileInputStream(new
		 * File("C:\\Users\\Zach\\Desktop\\Spring 20\\Cloud\\Disqus\\6971761113_20181015141058.txt"
		 * )); Reader reader = new InputStreamReader(inputStream, "UTF-8"); Gson gson =
		 * new GsonBuilder().create(); JsonStreamParser jsonStreamParser = new
		 * JsonStreamParser(reader); JsonArray jsonArray = new JsonArray();
		 * 
		 * while (jsonStreamParser.hasNext()) { JsonElement jsonElement =
		 * jsonStreamParser.next(); if (jsonElement.isJsonObject()) {
		 * jsonArray.add(jsonElement); System.out.println(jsonArray.size()); } }
		 */
		Set<Long> articleIDs = new HashSet<Long>();

		JFileChooser chooser = new JFileChooser();
	    chooser.setCurrentDirectory(new java.io.File("."));
	    chooser.setDialogTitle("Select the directory of JSON .txt");
	    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    chooser.setAcceptAllFileFilterUsed(false);

	    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	    	System.out.println("SelectedDirectoryFile : " + chooser.getSelectedFile());
	    } else {
	    	System.out.println("No Selection ");
	    	System.exit(1);
	    }
	    		
		File folder = chooser.getSelectedFile();
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				articleIDs.add(Long.valueOf(listOfFiles[i].getName().split("_", 0)[0]));
				System.out.println("File " + listOfFiles[i].getName());
			} else if (listOfFiles[i].isDirectory()) {
			}
		}

		articleIDs.forEach(n -> {
			long newestArticle = 0;
			File newestFile = null;
			List<File> olderFiles = new ArrayList<File>();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					String[] fileSplit = listOfFiles[i].getName().split("_", 0);
					if (Long.parseLong(fileSplit[0]) == n) {
						olderFiles.add(listOfFiles[i]);
						if (Long.parseLong(fileSplit[1].split("\\.")[0]) > newestArticle) {
							newestArticle = Long.parseLong(fileSplit[1].split("\\.")[0]);
							newestFile = listOfFiles[i];
						}
					}
					// System.out.println("File " + listOfFiles[i].getName());
				} else if (listOfFiles[i].isDirectory()) {
				}
			}
			olderFiles.remove(newestFile);
			ObjectStructure[] newestArray = null;
			try {
				newestArray = fileToObjArray(newestFile);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			List<Response> workingListOfResponses = new ArrayList<>();
			for (int i = 0; i < newestArray.length; i++) {
				workingListOfResponses.addAll((newestArray[i].getResponse()));
			}

			for (int i = 0; i < olderFiles.size(); i++) {
				ObjectStructure[] olderArray = null;
				try {
					olderArray = fileToObjArray(olderFiles.get(i));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for (int j = 0; j < olderArray.length; j++) {

					olderArray[j].getResponse().forEach(m -> {
						if (!workingListOfResponses.contains(m)) {
							workingListOfResponses.add(m);
						}
					});
				}
			}

			Gson gson = new GsonBuilder().create();
			File outputDir = new File(folder.getAbsolutePath() + "\\outputs");
	        if (!outputDir.exists()) {
	            if (outputDir.mkdir()) {
	                System.out.println("Directory is created!");
	            } else {
	                System.out.println("Failed to create directory!");
	            }
	        }
			
			String fileName = outputDir.getAbsolutePath() + "\\" + n.toString() + ".txt";
			
			try {
				gson.toJson(workingListOfResponses, new FileWriter(fileName));
			} catch (JsonIOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(fileName);
		});

		/*
		 * int[] filesPerArticle = new int[articleIDs.size()]; int[] newestArticle = new
		 * int[articleIDs.size()]; Arrays.fill(filesPerArticle, 0);
		 * Arrays.fill(newestArticle, 0);
		 */
		/*
		 * File fileA = new
		 * File("C:\\Users\\Zach\\Desktop\\Spring 20\\Cloud\\Disqus\\6971761113_20181015141058.txt"
		 * ); File fileB = new
		 * File("C:\\Users\\Zach\\Desktop\\Spring 20\\Cloud\\Disqus\\6971761113_20181015144051.txt"
		 * ); File fileC = new
		 * File("C:\\Users\\Zach\\Desktop\\Spring 20\\Cloud\\Disqus\\6971761113_20181015151911.txt"
		 * );
		 * 
		 * String[] fileAParts = fileA.getName().split("_", 0); String[] fileBParts =
		 * fileB.getName().split("_", 0); String[] fileCParts =
		 * fileC.getName().split("_", 0);
		 * 
		 * 
		 * ObjectStructure[] newerArray; ObjectStructure[] olderArray;
		 * 
		 * if (Long.parseLong(fileAParts[1].split("\\.", 0)[0]) >
		 * Long.parseLong(fileBParts[1].split("\\.", 0)[0])) { newerArray =
		 * fileToObjArray(fileA); olderArray = fileToObjArray(fileB); } else {
		 * newerArray = fileToObjArray(fileB); olderArray = fileToObjArray(fileA); }
		 * 
		 * newerArray = fileToObjArray(fileC); olderArray = fileToObjArray(fileA);
		 * 
		 * List<Response> workingListOfResponses = new ArrayList<>(); for (int i = 0; i
		 * < newerArray.length; i++) {
		 * workingListOfResponses.addAll((newerArray[i].getResponse()));
		 * System.out.println(newerArray[i].getResponse().size()); }
		 * //System.out.println(workingListOfResponses.size());
		 * //workingListOfResponses.forEach(n -> System.out.print(n.getId()+ " / "));
		 * for (int i = 0; i < olderArray.length; i++) { /*for (int j = 0; i <
		 * olderArray[i].getResponse().size(); j++) { if
		 * (!workingListOfResponses.contains(olderArray[i].getResponse().get(j))) {
		 * workingListOfResponses.add(olderArray[i].getResponse().get(j)); } }
		 */
		/*
		 * olderArray[i].getResponse().forEach(n -> { if
		 * (!workingListOfResponses.contains(n)) { workingListOfResponses.add(n); } });
		 * 
		 * System.out.println(olderArray[i].getResponse().size()); }
		 * 
		 * olderArray = fileToObjArray(fileB); for (int i = 0; i < olderArray.length;
		 * i++) { /*for (int j = 0; i < olderArray[i].getResponse().size(); j++) { if
		 * (!workingListOfResponses.contains(olderArray[i].getResponse().get(j))) {
		 * workingListOfResponses.add(olderArray[i].getResponse().get(j)); } }
		 */
		/*
		 * olderArray[i].getResponse().forEach(n -> { if
		 * (!workingListOfResponses.contains(n)) { workingListOfResponses.add(n); } });
		 * 
		 * System.out.println(olderArray[i].getResponse().size()); }
		 * 
		 * /* //Set<String> ms = new HashSet(); //ms.addAll(workingListOfResponses);
		 * //workingListOfResponses.forEach(n -> ms.add(n.getId()));
		 * System.out.println(workingListOfResponses.size());
		 * 
		 * Response r1 = new Response();
		 * r1.setId(workingListOfResponses.get(3).getId()); Response r2 = new
		 * Response(); r2.setId(workingListOfResponses.get(4).getId()); List<Response>
		 * w1 = new ArrayList<>(); if (!workingListOfResponses.contains(r1)) {
		 * workingListOfResponses.add(r1); }
		 * 
		 * if (!workingListOfResponses.contains(r2)) { workingListOfResponses.add(r2); }
		 */
		/*
		 * Set<Response> workingSetOfResponses = new HashSet<>(); for (int i = 0; i <
		 * newerArray.length; i++) { newerArray[i].getResponse().forEach(n -> {
		 * workingSetOfResponses.add(n); });
		 * System.out.println(newerArray[i].getResponse().size()); } for (int i = 0; i <
		 * olderArray.length; i++) { olderArray[i].getResponse().forEach(n -> {
		 * workingSetOfResponses.add(n); });
		 * 
		 * System.out.println(olderArray[i].getResponse().size()); }
		 * 
		 * olderArray = fileToObjArray(fileB); for (int i = 0; i < olderArray.length;
		 * i++) { olderArray[i].getResponse().forEach(n -> {
		 * workingSetOfResponses.add(n); });
		 * System.out.println(olderArray[i].getResponse().size()); }
		 * 
		 * Response r1 = new Response();
		 * r1.setId(workingListOfResponses.get(3).getId()); Response r2 = new
		 * Response(); r2.setId(workingListOfResponses.get(4).getId());
		 * 
		 * workingSetOfResponses.add(r1); workingSetOfResponses.add(r2);
		 * 
		 * Set<String> ms = new HashSet<String>(); workingListOfResponses.forEach(n -> {
		 * ms.add(n.getId()); System.out.print(ms.size() + " ^ "); });
		 * 
		 * System.out.println("\n" + workingListOfResponses.size() + " | " + ms.size() +
		 * " | " + workingSetOfResponses.size());
		 * 
		 * 
		 */
	}

	static ObjectStructure[] fileToObjArray(File file) throws FileNotFoundException, UnsupportedEncodingException {

		InputStream inputStream = null;
		inputStream = new FileInputStream(file);
		Reader reader;
		reader = new InputStreamReader(inputStream, "UTF-8");

		Gson gson = new GsonBuilder().create();
		JsonStreamParser jsonStreamParser = new JsonStreamParser(reader);
		JsonArray jsonArray = new JsonArray();
		while (jsonStreamParser.hasNext()) {
			JsonElement jsonElement = jsonStreamParser.next();
			if (jsonElement.isJsonObject()) {
				jsonArray.add(jsonElement);
			}
		}

		ObjectStructure[] returnObjs = new ObjectStructure[jsonArray.size()];
		for (int i = 0; i < jsonArray.size(); i++) {
			returnObjs[i] = gson.fromJson(jsonArray.get(i), ObjectStructure.class);
		}
		return returnObjs;
	}
}
