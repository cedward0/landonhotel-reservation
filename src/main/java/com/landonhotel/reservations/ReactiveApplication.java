package com.landonhotel.reservations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoReactiveDataAutoConfiguration;


/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
@SpringBootApplication(exclude = MongoReactiveDataAutoConfiguration.class)
public class ReactiveApplication
{
	//~ Methods ----------------------------------
	/**
	 * DOCUMENT ME!
	 *
	 * @param  args
	 */
	public static void main(String[] args)
	{
		SpringApplication.run(ReactiveApplication.class, args);
	}
}
