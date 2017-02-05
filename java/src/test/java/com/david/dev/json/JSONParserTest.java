package com.david.dev.json;

import java.util.Collections;


import org.junit.Test;

import com.david.dev.json.domain.FootballGroundEntry;

public class JSONParserTest {

	@Test
	public void test() {
		FootballGroundEntry testEntry = new FootballGroundEntry("Carrow Road", 52.37, 1.38);
		JSONTranslator translator = new JSONTranslator();
		String output = translator.createJSONObjects(Collections.singletonList(testEntry));
		System.out.println(output);
	}
}
