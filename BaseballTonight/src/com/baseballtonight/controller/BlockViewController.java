package com.baseballtonight.controller;

import java.util.HashSet;

import com.baseballtonight.util.console.Coloring;
import com.baseballtonight.util.console.UserInput;
import com.baseballtonight.view.block.BlockView;
import com.baseballtonight.view.block.BlueBlockView;
import com.baseballtonight.view.block.GreenBlockView;
import com.baseballtonight.view.block.NavyBlockView;
import com.baseballtonight.view.block.RedBlockView;
import com.baseballtonight.view.block.TableBlockView;

public class BlockViewController {
	static HashSet<String> page_cmd = new HashSet<>();
	static {
		page_cmd.add("a");
		page_cmd.add("d");
		page_cmd.add("s");
	}
	
	static BlockView view;
	
	public static Object showSeatBlocks(String seatType) {
		switch(seatType){
		case "premium":
			return null;
			
		case "table":
			view = new TableBlockView();
			break;
			
		case "blue":
			view = new BlueBlockView();
			break;
			
		case "red":
			view = new RedBlockView();
			break;
			
		case "navy":
			view = new NavyBlockView();
			break;
			
		case "green":
			view = new GreenBlockView();
			break;
		}
		String cmdList = Coloring.getCyan("a: 이전 페이지")  +"  |  "+  Coloring.getYellow("s: 블럭 선택하기")  +"  |  "+ Coloring.getCyan("d: 다음 페이지");
		
		// 처음은 1번 페이지부터 보이기.
		view.showFirstPage();
		System.out.println(cmdList);
		
		// 페이지 넘어가기 선택.
		while(true){
			String pagePosition = UserInput.receiveContainedString(page_cmd);
			
			// 명령어가 "choice"라면, block 선택 페이지로 이동.
			if(pagePosition.equals("s")){
				break;
			}
			
			view.showBlock(pagePosition);
			System.out.println(cmdList);
		}
		return null;
	}
}









