package com.csw.converters.impls;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

import com.csw.converters.XMLJSONConverterI;

public class UsingGSONLibraryImpl implements XMLJSONConverterI {

	@Override
	public void convertJSONtoXML(File json, File xml) throws IOException {
		// TODO Auto-generated method stub
		Arrays.asList("").stream().collect(Collectors.toMap(null, null))
	}

}
