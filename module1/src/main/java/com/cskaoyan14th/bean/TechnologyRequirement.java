package com.cskaoyan14th.bean;

import java.util.Date;

 public  class TechnologyRequirement {
        private String technologyRequirementId;

        private String technologyId;

        private String requirement;

        private Date addTime;

        private Date reviseTime;

     public String getTechnologyRequirementId() {
         return technologyRequirementId;
     }

     public void setTechnologyRequirementId(String technologyRequirementId) {
         this.technologyRequirementId = technologyRequirementId;
     }

     public String getTechnologyId() {
         return technologyId;
     }

     public void setTechnologyId(String technologyId) {
         this.technologyId = technologyId;
     }



     public String getRequirement() {
         return requirement;
     }

     public void setRequirement(String requirement) {
         this.requirement = requirement;
     }

     public Date getAddTime() {
         return addTime;
     }

     public void setAddTime(Date addTime) {
         this.addTime = addTime;
     }

     public Date getReviseTime() {
         return reviseTime;
     }

     public void setReviseTime(Date reviseTime) {
         this.reviseTime = reviseTime;
     }

     public TechnologyRequirement(String technologyRequirementId, String technologyId, String requirement, Date addTime, Date reviseTime) {
         this.technologyRequirementId = technologyRequirementId;
         this.technologyId = technologyId;

         this.requirement = requirement;
         this.addTime = addTime;
         this.reviseTime = reviseTime;
     }

     public TechnologyRequirement() {
     }

     @Override
     public String toString() {
         return "TechnologyRequirement{" +
                 "technologyRequirementId='" + technologyRequirementId + '\'' +
                 ", technologyId='" + technologyId + '\'' +
                 ", requirement='" + requirement + '\'' +
                 ", addTime=" + addTime +
                 ", reviseTime=" + reviseTime +
                 '}';
     }
     /*上面是逆向工程自动生成的，下面是自己手动添加的*/

 }

