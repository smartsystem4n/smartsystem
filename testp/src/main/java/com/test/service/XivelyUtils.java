package com.test.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.TimeZone;

import com.test.entity.Entity;
import com.test.entity.Room;
import com.xively.client.XivelyService;
import com.xively.client.model.Datapoint;
import com.xively.client.model.Datastream;
import com.xively.client.model.Feed;

public abstract class XivelyUtils {
	
	public static synchronized void updateXively(Room room,Entity entity,String status)
	{
		// check Dummy Repository where we have created feed
		Feed feed = XivelyService.instance().feed().get(523845924) ;
		setDataStreams(entity, status, feed);
		
		
//		TimeZone tz = TimeZone.getTimeZone("UTC");
//	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
//	    df.setTimeZone(tz);
//	    String nowAsISO = df.format(new Date());
	    //feed.setUpdatedAt(nowAsISO) ;
	    //feed.setUpdatedAt(new Date().toString());
		XivelyService.instance().feed().update(feed) ;
	}

	public static void setDataStreams(Entity entity, String status, Feed feed) {
		Collection<Datastream> datastreamCollection = feed.getDatastreams() ;
		
		if(null == datastreamCollection)
		{
			datastreamCollection = new ArrayList<Datastream>() ;
			feed.setDatastreams(datastreamCollection);
		}
		Datastream temp = null ;
		for(Datastream ds : datastreamCollection)
		{
//			System.out.println("1");
//			Collection<Datapoint> dps = new ArrayList<Datapoint>() ;
//			Datapoint dp = XivelyService.instance().datapoint(feed.getId(), ds.getId()).get(ds.getUpdatedAt()) ;
//			dps.add(dp);
//			System.out.println("2");
//			System.out.println(dps);
//			System.out.println("3");
//			System.out.println(dps.size());
//			ds.setDatapoints(dps);
//			System.out.println(ds.getDatapoints()) ;
			if(ds.getId().equals(entity.getId()+entity.getLabel()))
			{
				temp = ds ;
			}
		}
		if(null == temp)
		{
			temp = new Datastream() ;
			temp.setId(entity.getId()+entity.getLabel());
			temp.setValue(entity.getLabel());
			datastreamCollection.add(temp) ;
		}
		temp.setUpdatedAt(new Date().toString());
		if(null == temp.getDatapoints())
		{
			temp.setDatapoints(new ArrayList<Datapoint>());
		}
		Datapoint dp = new Datapoint() ;
		dp.setValue(status) ;
		dp.setAt(new Date().toString());
		temp.getDatapoints().add(dp);
	}

}
