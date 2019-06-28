package com.cskaoyan14th.vo;

public class ResponseVoBox {
   public ResponseVo Box (int i){
       ResponseVo responseVo = new ResponseVo();
       if (i!= 0){
           responseVo.setMsg("OK");
           responseVo.setStatus(200);

       }else {
           responseVo.setMsg("ERROR");
           responseVo.setStatus(500);

       }
       return responseVo;
   }
}
