/**
 * 
 */
package mum.wap.game.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import org.codehaus.jettison.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @author romiezaw
 *
 */
public class GameService {
	private int numberToGuess;

	public GameService() {
		
	}

	public int getNumberToGuess() {
		return numberToGuess;
	}

	public void setNumberToGuess(int numberToGuess) {
		this.numberToGuess = numberToGuess;
	}

	@SuppressWarnings("unchecked")
	// written by Romie on March 18
	// class for game
	public JSONObject solveIt() {
		
		int[] numberArr = { 0, 4, 6, 7 };
		
		Map<String, List<Integer>> numberMap = new HashMap<>();
		int totalDigitCounter = 0;
		int positionCounter = 0;
		int number = numberToGuess;
		int[] userSelectedDigits = new int[4];				 // Convert the number into int[]
		List<Integer> matchingArr = new ArrayList<>(); 		 // int[] for matching pair
		StringBuilder buffer = new StringBuilder();			 //to allow leading zeros

		for (int i = 0; i < 4; i++) {
			int divider = (int) (Math.pow(10, (3 - i)));
			userSelectedDigits[i] = (int) number / divider;
			buffer.append(userSelectedDigits[i]);
			number = number % divider;
		}
		
		int index = -1; 														// Counter to control the loop and get the position of digit
		for (int digit : userSelectedDigits) {
			index++;
			boolean found = IntStream.of(numberArr).
					anyMatch(savedDigit -> savedDigit == digit); 			// Find a digit in original number																		
			if (found) { 														// If found, check the position
				totalDigitCounter++;
				for (int j = 0; j < numberArr.length; j++) {
					if (digit == numberArr[j]) {
						if (index == j)
							positionCounter++;
					}
				}
			}
		}
		matchingArr.add(totalDigitCounter);
		matchingArr.add(positionCounter);
		numberMap.put(buffer.toString(), matchingArr);
		return toJson(numberMap);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static JSONObject toJson(Map<String, List<Integer>> map) {
		JSONObject jsonObject = new JSONObject();
		for (String key : map.keySet()) {
			List<Integer> list = map.get(key);
			if (list instanceof List) {
				jsonObject.put("number", key);
				jsonObject.put("match", toJson((List) list));
			}
		}
		return jsonObject;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static JSONArray toJson(List list) {
		JSONArray jsonArray = new JSONArray();
		for (Object obj : list) {
			if (obj instanceof List) {
				jsonArray.add(toJson((List) obj));
			} else {
				jsonArray.add(obj);
			}
		}
		return jsonArray;
	}

}
