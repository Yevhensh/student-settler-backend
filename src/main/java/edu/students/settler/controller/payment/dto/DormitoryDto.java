package edu.students.settler.controller.payment.dto;

import lombok.Data;

import java.util.Set;

@Data
public class DormitoryDto {
    private long id;
    private String number;
    private Set<RoomDto> roomDtos;
    private PriceDto price;
}