package com.right2vote.service;

import java.util.List;

import com.right2vote.exception.instrumentException;
import com.right2vote.model.Instrumnets;

public interface r2vService {

	public Instrumnets addDetails(Instrumnets instrumnets) throws instrumentException;
	
	public Instrumnets deleteData(Integer instrumnetId) throws instrumentException;
	
	public String optimalInstruments() throws instrumentException;

//	String optimalInstruments(double[] arr2, int j, double d, int k) throws instrumentException;

//	public String optimalInstruments() throws instrumentException;

//	String optimalInstruments(double[] arr, int l, Double r, Double sum) throws instrumentException;
	
}
