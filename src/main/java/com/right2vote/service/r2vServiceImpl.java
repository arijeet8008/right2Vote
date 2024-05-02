package com.right2vote.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.right2vote.exception.instrumentException;
import com.right2vote.model.Instrumnets;
import com.right2vote.repo.r2vRepo;

@Service
public class r2vServiceImpl implements r2vService{

	@Autowired
	private r2vRepo repo;

	@Override
	public Instrumnets addDetails(Instrumnets instrumnets) throws instrumentException {
		
		Instrumnets instrumnets2 = repo.save(instrumnets);
		return instrumnets2;
		
	}

	@Override
	public Instrumnets deleteData(Integer instrumnetId) throws instrumentException {
		
		Optional<Instrumnets> opt = repo.findById(instrumnetId);
		
		if(opt.isPresent()) {
			
			Instrumnets instrumnets = opt.get();
			repo.delete(instrumnets);
			return instrumnets;
			
		}
		
		else
			throw new instrumentException("Invalid Id..");
		
	}

	@Override
	public String optimalInstruments() throws instrumentException {

		List<Instrumnets> list = repo.findAll();
		int sum = 0;
//		double[] arr = new double[list.size()];
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i).getScientificValue();
		}
//		List<Double> res = new ArrayList<>();
//		
//		if(l>r) {
//			res.add(sum);
//			return null;
//		}
		
//		optimalInstruments(arr,l+1,r,sum+ arr[l]);
//		optimalInstruments(arr,l+1,r,sum);
		
		return list+"\n"+"Scientific Value"+sum;

	}
	
//	public static void main(String[] args) throws instrumentException {
//
//		List<Instrumnets> list = repo.findAll();
//		
//		double[] arr = new double[list.size()];
//		
//		for (int i = 0; i < list.size(); i++) {
//			Double w = list.get(i).getWeight();
//			arr[i] = w;
//		}
//		double n = arr.length;
//
//		r2vService r2vService = new r2vServiceImpl();
//		r2vService.optimalInstruments(arr,0,n-1,0.0);
//		
//	}

	
}
