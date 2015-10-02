package com.youzan.easyranking.cache;

import java.util.TimerTask;
/**
 * 
 * To improve performance, any changes triggered by ui will be cached in memory
 * Synchronize the cache with DB when:
 * 1. changes exceeds the max number(configurable).
 * OR
 * 2. period time elapsed(configurable)
 * 
 *
 */
public class CacheSynchTimer extends TimerTask {

	@Override
	public void run() {
				
	}

}
