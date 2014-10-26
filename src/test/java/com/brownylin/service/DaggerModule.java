package com.brownylin.service;

import com.brownylin.leetcode.DynamicProgramming;
import com.brownylin.leetcode.StringProcessing;
import dagger.Module;
import dagger.ObjectGraph;

@Module(
	injects = {
		JodaTimeService.class,
		InterviewService.class,
		StringProcessing.class,
		DynamicProgramming.class
	}
)
public class DaggerModule
{
	private static final ObjectGraph objectGraph = ObjectGraph.create(new DaggerModule());

	public static ObjectGraph getObjectGraph() {
		return objectGraph;
	}

}
