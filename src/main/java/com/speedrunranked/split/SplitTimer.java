package com.speedrunranked.split;

import java.util.ArrayList;
import java.util.List;

public class SplitTimer {
	private List<Split> splits;
	private long lastSplitTime;

	public SplitTimer() {
		this.splits = new ArrayList<>();
		this.lastSplitTime = 0;
	}

	public void addSplit(String name, long currentTime) {
		Split split = new Split(name, currentTime, currentTime - lastSplitTime);
		splits.add(split);
		lastSplitTime = currentTime;
	}

	public List<Split> getSplits() {
		return new ArrayList<>(splits);
	}

	public static class Split {
		public String name;
		public long totalTime;
		public long splitTime;

		public Split(String name, long totalTime, long splitTime) {
			this.name = name;
			this.totalTime = totalTime;
			this.splitTime = splitTime;
		}
	}
}
