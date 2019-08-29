package com.capsuleCRM.dataStorage;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

import com.capsuleCRM.utility.GetDataFromExcel;

public class DataProviderClass{

	String personSheet = "Persons";
	String casesSheet = "Cases";
	
	String userSheet = "Users";
	String milestoneSheet = "Milestones";
	String trackSheet = "Tracks";
	String taskSheet = "Tasks";
	String tagSheet = "Tags";
	
	@DataProvider
	public Object[][] getPeopleData() throws InvalidFormatException{
		Object data[][] = GetDataFromExcel.getData(personSheet);
		return data;
	}
	
	@DataProvider
	public Object[][] getCasesData() throws InvalidFormatException{
		Object data[][] = GetDataFromExcel.getData(casesSheet);
		return data;
	}
	
	
	@DataProvider
	public Object[][] getUserData() throws InvalidFormatException {
		Object data[][] = GetDataFromExcel.getData(userSheet);
		return data;
	}
	
	@DataProvider
	public Object[][] getMilestoneData() throws InvalidFormatException {
		Object data[][] = GetDataFromExcel.getData(milestoneSheet);
		return data;
	}
	
	@DataProvider
	public Object[][] getTracksData() throws InvalidFormatException {
		Object data[][] = GetDataFromExcel.getData(trackSheet);
		return data;
	}
	
	@DataProvider
	public Object[][] getTasksData() throws InvalidFormatException {
		Object data[][] = GetDataFromExcel.getData(taskSheet);
		return data;
	}
	
	@DataProvider
	public Object[][] getTagsData() throws InvalidFormatException {
		Object data[][] = GetDataFromExcel.getData(tagSheet);
		return data;
	}
	
}
