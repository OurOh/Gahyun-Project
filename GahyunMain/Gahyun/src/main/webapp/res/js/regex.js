const regex = {
   value: function(selector, msg) {
      var target = $(selector);  //선택한 변수를 target에 저장
      if(!target.val()){  //target에 값이 없으면
         alert(msg);  //메시지 변수를 표시
         target.focus();
         return false;
      }
      return true;
   },
   
   /* max 길이 제한 */
   max_length : function(selector, len, msg) {
      var target = $(selector);
      if(target.val().length > len) {
        alert(msg);
        target.val("");
        target.focus();
        return false;
      }
      return true;
   },
   
   /* min 길이 제한 */
    min_length : function(selector, len, msg) {
      var target = $(selector);
      if(target.val().length < len) {
        alert(msg);
        target.val("");
        target.focus();
        return false;
      }
      return true;
   },  
   
   /* 입력값이 정규식에 맞는 지 */
   field : function(selector, msg, regex_expr){
      var target = $(selector);
      if(!target.val() || !regex_expr.test(target.val())){
         alert(msg);
         target.val("");
         target.focus();
         return false;
      }
      return true;
   },
   
   /* 두 필드가 같은지 */
   equalField : function(origin, compare, msg){
      var src = $(origin);
      var dsc = $(compare);
      if(src.val() != dsc.val()){
        alert(msg);
        src.val("");
        dsc.val("");
        src.focus();
        return false;
      }
      return true;
   },
   /*
    전화번호 정규식
   tel: function(selector, msg) {
      return this.field(selector, msg, /^(01[0-9]{1})([ -]?\d{3,4})([ -]?\d{4})$/);
   },
   */
   /* 아이디 조건 - 첫자는 영문만, 두번째 부터는 영, 수 , 3자 이상*/
   uid: function(selector, msg) {
      return this.field(selector, msg, /^[a-zA-Z][a-zA-Z0-9]{2,}$/);
   },
   
   /* 이메일 */
   email : function(selector, msg) {
      return this.field(selector, msg, /^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/);
   }
}