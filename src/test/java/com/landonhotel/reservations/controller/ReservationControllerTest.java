package com.landonhotel.reservations.controller;

import com.landonhotel.reservations.model.Reservation;

import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.context.ApplicationContext;

import org.springframework.http.MediaType;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReservationControllerTest
{
	//~ Instance fields --------------------------
	/**  */
	@Autowired
	private ApplicationContext context;

	/**  */
	private Reservation reservation;

	/**  */
	private WebTestClient webTestClient;
	//~ Methods ----------------------------------
	/** DOCUMENT ME! */
	@Test
	void createReservation()
	{
		webTestClient = WebTestClient.bindToApplicationContext(this.context).build();
		reservation = new Reservation(100L, LocalDate.now(), LocalDate.now().plus(10, ChronoUnit.DAYS), 200);
		webTestClient.get().uri(ReservationController.ROOM_V_1_RESERVATION).exchange().expectStatus().isOk()
			.expectBodyList(Reservation.class);
	}

	/** DOCUMENT ME! */
	@Test
	void getAllReservations()
	{
		webTestClient = WebTestClient.bindToApplicationContext(this.context).build();
		reservation = new Reservation(100L, LocalDate.now(), LocalDate.now().plus(10, ChronoUnit.DAYS), 200);
		webTestClient.post().uri(ReservationController.ROOM_V_1_RESERVATION).body(Mono.just(reservation),
			Reservation.class).exchange().expectStatus().isOk().expectHeader().contentType(
			MediaType.APPLICATION_JSON_UTF8).expectBody(Reservation.class);
	}
}
