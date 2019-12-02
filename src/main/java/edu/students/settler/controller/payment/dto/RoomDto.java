package edu.students.settler.controller.payment.dto;

import lombok.Data;

import java.util.List;

@Data
public class RoomDto {
    private long id;
    private String number;
    private List<RoomSlotDto> slots;
    private DormitoryDto dormitory;
}