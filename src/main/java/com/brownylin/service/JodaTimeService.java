package com.brownylin.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.joda.time.DateTime;
import org.joda.time.Interval;

public class JodaTimeService
{
	@Inject
	public JodaTimeService() {}

	/**
	 * Divide the interval between `start` and `end` time to `chuckAmount` equal
	 * `chunkSize` intervals
	 */
	public List<Interval> splitDuration(DateTime start, DateTime end, long chunkAmount,
		long chunkSize)
	{
		long millis = start.getMillis();
		List<Interval> list = new ArrayList<Interval>();

		for (int i = 0; i < chunkAmount; ++i) {
			list.add(new Interval(millis, millis += chunkSize));
		}

		list.add(new Interval(millis, end.getMillis()));

		return list;
	}

	public Timestamp jodaDateTime2Timestamp(DateTime dateTime)
	{
		return new Timestamp(dateTime.getMillis());
	}

}
