package com.landonhotel.reservations.controller;

import com.landonhotel.reservations.model.Reservation;
import com.landonhotel.reservations.service.ReservationService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
@CrossOrigin
@RequestMapping(ReservationController.ROOM_V_1_RESERVATION)
@RestController
public class ReservationController
{
	//~ Static fields/initializers ---------------
	/**  */
	public static final String ROOM_V_1_RESERVATION = "/room/v1/reservation/";
	//~ Instance fields --------------------------
	/**  */
	private final ReservationService reservationService;
	//~ Constructors -----------------------------
	/**
	 * Creates a new ReservationResource object.
	 *
	 * @param  reservationService
	 */
	@Autowired
	public ReservationController(ReservationService reservationService)
	{
		this.reservationService = reservationService;
	}
	//~ Methods ----------------------------------
	/**
	 * DOCUMENT ME!
	 *
	 * @return
	 */
	@GetMapping(
		path = "{id}",
		produces = MediaType.APPLICATION_JSON_UTF8_VALUE
	)
	public Mono<Reservation> getReservationById(@PathVariable
		String id)
	{
		return reservationService.getReservation(id);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param   reservation
	 * @return
	 */
	@PostMapping(
		path = "",
		produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
		consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
	)
	public Mono<Reservation> createReservation(@RequestBody
		Mono<Reservation> reservation)
	{
		return reservationService.createReservation(reservation);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param   id
	 * @param   reservation
	 * @return
	 */
	@PutMapping(
		path = "{id}",
		produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
		consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
	)
	public Mono<Reservation> updatePrice(@PathVariable
		String id, @RequestBody
		Mono<Reservation> reservation)
	{
		return reservationService.updateReservation(id, reservation);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param   id
	 * @return
	 */
	@DeleteMapping(
		path = "{id}",
		produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
		consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
	)
	public Mono<Boolean> updatePrice(@PathVariable
		String id)
	{
		return reservationService.deleteReservation(id);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return
	 */
	@GetMapping(
		path = "",
		produces = MediaType.APPLICATION_JSON_UTF8_VALUE
	)
	public Flux<Reservation> getAllReservations()
	{
		return reservationService.listAllReservations();
	}
}
