package com.landonhotel.reservations.service;

import com.landonhotel.reservations.model.Reservation;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
@Service
public class ReservationServiceImpl implements ReservationService
{
	//~ Instance fields --------------------------
	/**  */
	private final ReactiveMongoOperations reactiveMongoOperations;
	//~ Constructors -----------------------------
	/**
	 * Creates a new ReservationServiceImpl object.
	 *
	 * @param  reactiveMongoOperations
	 */
	@Autowired
	public ReservationServiceImpl(ReactiveMongoOperations reactiveMongoOperations)
	{
		this.reactiveMongoOperations = reactiveMongoOperations;
	}
	//~ Methods ----------------------------------
	/** @see  ReservationService#getReservation(java.lang.String) */
	@Override
	public Mono<Reservation> getReservation(String id)
	{
		return reactiveMongoOperations.findById(id, Reservation.class);
	}
	
	/** @see  ReservationService#createReservation(reactor.core.publisher.Mono) */
	@Override
	public Mono<Reservation> createReservation(Mono<Reservation> reservationMono)
	{
		return reactiveMongoOperations.save(reservationMono);
	}
	
	/** @see  ReservationService#updateReservation(java.lang.String, reactor.core.publisher.Mono) */
	@Override
	public Mono<Reservation> updateReservation(String id, Mono<Reservation> reservationMono)
	{
		// return reactiveMongoOperations.save(reservationMono);
		return reservationMono.flatMap(reservation ->
				reactiveMongoOperations.findAndModify(
					Query.query(Criteria.where("id").is(id)),
					Update.update("price", reservation.getPrice()),
					Reservation.class).flatMap(result ->
				{
					result.setPrice(reservation.getPrice());

					return Mono.just(result);
				}));
	}
	
	/** @see  ReservationService#deleteReservation(java.lang.String) */
	@Override
	public Mono<Boolean> deleteReservation(String id)
	{
		return reactiveMongoOperations.remove(
			Query.query(Criteria.where("id").is(id)), Reservation.class).flatMap(deleteResult ->
				Mono.just(deleteResult.wasAcknowledged()));
	}
	
	/** @see  ReservationService#listAllReservations() */
	@Override
	public Flux<Reservation> listAllReservations()
	{
		return reactiveMongoOperations.findAll(Reservation.class);
	}
}
