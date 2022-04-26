package com.org.acme.patient.onboarding.service;


import com.org.acme.patient.onboarding.controller.repository.IOnboardingPatientRepository;
import org.acme.patient.onboarding.model.Doctor;
import org.acme.patient.onboarding.model.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import java.util.stream.Stream;

@Service
public class OnboardingServiceImpl implements IOnboardingService{

    @Autowired
    IOnboardingPatientRepository repository;

    @Override
    public Mono<Hospital> getParticipatingHospital(String zip) {
        Flux<Hospital> hospitalFlux= repository.getParticipatingHospitals();
        Stream<Hospital> hospitals = hospitalFlux.toStream();
        Hospital hospital = hospitals.filter(h -> h.getZip().equals(zip))
                .findFirst()
                .orElse(new Hospital("Local Hospital","123 Local Street", "555-55-5555", "12345"));

        return Mono.just(hospital);
    }

    @Override
    public Mono<Doctor> getParticipatingDoctor(String condition) {
        Flux<Doctor> doctorFlux= repository.getParticipatingDoctors();
        Stream<Doctor> doctors = doctorFlux.toStream();
        Doctor doctor = doctors.filter(d -> d.getSpecialty().equals(condition))
                .findFirst()
                .orElse(new Doctor("Michael Scott", "img/docfemale.png", "General"));

        return Mono.just(doctor);
    }
}
        