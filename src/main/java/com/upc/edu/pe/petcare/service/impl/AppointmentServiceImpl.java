package com.upc.edu.pe.petcare.service.impl;

import com.upc.edu.pe.petcare.dto.AppointmentRequest;
import com.upc.edu.pe.petcare.dto.response.AppointmentResponse;
import com.upc.edu.pe.petcare.exception.ModelNotFoundException;
import com.upc.edu.pe.petcare.model.*;
import com.upc.edu.pe.petcare.repository.*;
import com.upc.edu.pe.petcare.service.AppointmentService;
import com.upc.edu.pe.petcare.util.AppointmentConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentServiceImpl extends CrudServiceImpl<Appointment, Long> implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PersonProfileRepository personProfileRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Autowired
    private AppointmentConverter appointmentConverter;

    @Override
    protected GenericRepository<Appointment, Long> getRepository() {
        return appointmentRepository;
    }

    @Override
    public AppointmentResponse register(AppointmentRequest appointmentRequest) throws Exception {
       try {
           Appointment appointment = appointmentConverter.convertDTOToEntity(appointmentRequest);
           PersonProfile personProfileDB = personProfileRepository.findById(appointmentRequest.getPersonProfile_id()).orElseThrow(()->new ModelNotFoundException("personProfile no encontrado"));
           Pet petDB = petRepository.findById(appointmentRequest.getPet_id()).orElseThrow(()->new ModelNotFoundException("pet no encontrado"));
           Provider providerDB = providerRepository.findById(appointmentRequest.getProvider_id()).orElseThrow(()-> new ModelNotFoundException("provider no encontrado"));
           Product productDB = productRepository.findById(appointmentRequest.getProduct_id()).orElseThrow(()-> new ModelNotFoundException("product no encontrado"));
           ProductType productTypeDB = productTypeRepository.findById(appointmentRequest.getProductType_id()).orElseThrow(()-> new ModelNotFoundException("productType no encontrado"));

           appointment.setPersonProfile(personProfileDB);
           appointment.setPet(petDB);
           appointment.setProvider(providerDB);
           appointment.setProduct(productDB);
           appointment.setProductType(productTypeDB);

           return appointmentConverter.convertEntityToDTO(appointmentRepository.save(appointment));

       } catch ( Exception e ){
           throw new Exception("Error en el register appointment: "+ e);
       }


    }

    @Override
    public List<AppointmentResponse> deleteAppointments(Long appointmentId, Long personProfileId) throws Exception {
        appointmentRepository.deleteById(appointmentId);
        return getAllByPersonProfileId(personProfileId);
    }

    @Override
    public List<AppointmentResponse> getAllByPersonProfileId(Long personProfileId) throws Exception {
        List<Appointment> appointmentList = appointmentRepository.getAppointmentsByPersonProfileId(personProfileId);
        return appointmentConverter.convertListEntityToDto(appointmentList);
    }



    @Override
    public List<AppointmentResponse> getAllByPersonProfileIdAndPetId(Long personProfileId, Long petId, int status) throws Exception {
        List<Appointment> appointmentList = appointmentRepository.getAppointmentsByPersonProfileIdAndPetIdAndStatus(personProfileId,petId,status);
        return appointmentConverter.convertListEntityToDto(appointmentList);
    }

    @Override
    public List<AppointmentResponse> getAllByPersonProfileIdAndStatus(Long personProfileId, int status) throws Exception {
        List<Appointment> appointmentList = appointmentRepository.getAppointmentsByPersonProfileIdAndStatus(personProfileId,status);
        return appointmentConverter.convertListEntityToDto(appointmentList);
    }

    @Override
    public List<AppointmentResponse> updateAppointmentByAppointmentIdAndStatus(Long appointmentId, int status, Long personProfileId, int isPersonOrBusinessId) throws Exception {
        Appointment appointmentDB = appointmentRepository.getById(appointmentId);
        appointmentDB.setStatus(status);
        Appointment updateAppointment = appointmentRepository.save(appointmentDB);
        List<AppointmentResponse> list = new ArrayList<>();
        if(isPersonOrBusinessId == 1){
            list = getAppointmentsByBusinessProfileId(personProfileId);
        }
        if(isPersonOrBusinessId == 0 ){
            list = getAllByPersonProfileId(personProfileId);
        }
        return list;
    }

    @Override
    public List<AppointmentResponse> getAppointmentsByBusinessProfileId(Long bussinessProfileId) throws Exception {
        List<Appointment> appointmentList = appointmentRepository.getAppointmentsByBusinessProfileId(bussinessProfileId);
        return appointmentConverter.convertListEntityToDto(appointmentList);
    }

    @Override
    public List<AppointmentResponse> getAppointmentsByBusinessProfileIdAndStatus(Long businessProfileId, int status) throws Exception {
        List<Appointment> appointmentList = appointmentRepository.getAppointmentsByBusinessssProfileIdAndStatus(businessProfileId,status);
        return appointmentConverter.convertListEntityToDto(appointmentList);
    }

    @Override
    public List<Integer> getAppointmentsByMesByBusinessProfileId(String mes, Long businessProfileId) throws Exception {
        List<Integer> list = new ArrayList<Integer>();
        // for hasta el mes que se ingresa
        for (int i = 1; i <= Integer.parseInt(mes) ; i++) {
            Integer lent = appointmentRepository.getAppointmentsByMesByBusinessProfileId(Integer.toString(i) ,businessProfileId).size();
            list.add(lent);
        }
        return list;
    }

    @Override
    public List<Integer> getCalculoConStatus1y2y3(Long businessProfileId) throws Exception {
        List<Integer> list = new ArrayList<Integer>();
        int status0 = appointmentRepository.getAppointmentsByBusinessssProfileIdAndStatus(businessProfileId, 0).size(); // pendientes
        int status1 = appointmentRepository.getAppointmentsByBusinessssProfileIdAndStatus(businessProfileId, 1).size(); // aceptados
        int status2 = appointmentRepository.getAppointmentsByBusinessssProfileIdAndStatus(businessProfileId, 2).size(); // anulados - cliente
        int status3 = appointmentRepository.getAppointmentsByBusinessssProfileIdAndStatus(businessProfileId, 3).size(); // rechazados - veterinaria

        list.add(status0);
        list.add(status1);
        list.add(status2);
        list.add(status3);

        return list;
    }


}
