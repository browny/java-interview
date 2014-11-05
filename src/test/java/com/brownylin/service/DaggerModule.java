package com.brownylin.service;

import com.brownylin.leetcode.ArrayProcessing;
import com.brownylin.leetcode.BackTracking;
import com.brownylin.leetcode.DynamicProgramming;
import com.brownylin.leetcode.StringProcessing;
import dagger.Module;
import dagger.ObjectGraph;

@Module(
	injects = {
		ArrayProcessing.class,
		BackTracking.class,
		DynamicProgramming.class,
		InterviewService.class,
		JodaTimeService.class,
		StringProcessing.class
	}
)
public class DaggerModule
{
	private static final ObjectGraph objectGraph = ObjectGraph.create(new DaggerModule());

	public static ObjectGraph getObjectGraph() {
		return objectGraph;
	}
}
