package com.example.second;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DriverService {
    private final DriverRepository driverRepository;


    // 기사님 등록
    public String save(Driver d){
        driverRepository.save(d);
        return d.getBus_uid();
    }
    // id로 기사님 검색
    public Driver findById(Integer id){
        return driverRepository.findById(id);
    }


    // 전체 기사님 조회
    public List<Driver> findAll(){
        return driverRepository.findAll();
    }

    public List<Driver> findName(){
        return driverRepository.findName();
    }
    public List<Driver> findBusUid(){
        return driverRepository.findBusUid();
    }
    public List<Driver> findBusNum(){
        return driverRepository.findBusNum();
    }
    public List<Driver> findPhoneNum(){
        return driverRepository.findPhoneNum();
    }
    public List<Driver> findCompany(){
        return driverRepository.findCompany();
    }

    // 전체 기사님 수
    public long countPassengers(){
        return driverRepository.countDrivers();
    }

    // 버스 번호판 으로 기사 검색
    public Driver findByUid(String busUid){
        return driverRepository.findByUid(busUid);
    }

    public void deleteDriver(String busUid){ driverRepository.remove(busUid);}



    // 기사님 수정 ( 승객이 등록될 때 수정됨 )
    public List<Driver> update(String bus_uid, String name, String phone_num, String company, String bus_num){
        System.out.println("driveservice"+ bus_uid);
        List updateDriver = driverRepository.findByUid2(bus_uid);

        if(name != null){
            System.out.println("error name");
        }
        if(phone_num != null){
            System.out.println("error phone_num");
        }
        if(company != null){
            System.out.println("error company");
        }
        if(bus_num != null){
            System.out.println("error bus_num");
        }
        if(updateDriver == null){
            System.out.println("error null");
        }

        driverRepository.save2(updateDriver); // 변경 내용을 저장

        return updateDriver;
    }



}
