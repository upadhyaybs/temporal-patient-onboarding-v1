package com.org.acme.patient.onboarding.controller.repository;

import org.acme.patient.onboarding.model.Doctor;
import org.acme.patient.onboarding.model.Hospital;
import reactor.core.publisher.Flux;


public interface IOnboardingPatientRepository {

    Flux<Hospital> getParticipatingHospitals();

    Flux<Doctor> getParticipatingDoctors();
}
