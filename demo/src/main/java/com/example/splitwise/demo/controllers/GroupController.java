package com.example.splitwise.demo.controllers;

import com.example.splitwise.demo.dto.GroupCreateRequestDto;
import com.example.splitwise.demo.dto.GroupCreateResponseDto;
import com.example.splitwise.demo.dto.ResponseStatus;
import com.example.splitwise.demo.models.Group;
import com.example.splitwise.demo.service.GroupService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/splitwisegroup")
public class GroupController {

   private GroupService groupService;

   public GroupController(GroupService groupService) {
       this.groupService = groupService;
   }

   @PostMapping("/createGroup")
   public @ResponseBody GroupCreateResponseDto createGroup(@RequestBody GroupCreateRequestDto groupCreateRequestDto) {
       GroupCreateResponseDto groupCreateResponseDto = new GroupCreateResponseDto();
     Group group =  groupService.createGroup(groupCreateRequestDto.getName(), groupCreateRequestDto.getUserIdList());
     groupCreateResponseDto.setGroup(group);
     groupCreateResponseDto.setStatus(ResponseStatus.SUCCESS);
       return groupCreateResponseDto;
   }

   @GetMapping("/getgroups")
  public List<Group> getAllGroups() {
       return groupService.getAllGroups();
  }
}
