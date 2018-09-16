/**
 * 
 */
 $(function () {
        $('.content').flexText();
    });
 function keyUP(t){
     var len = $(t).val().length;
     if(len > 139){
         $(t).val($(t).val().substring(0,140));
     }
 }
 $('.comment-show').on('click','.pl-hf',function(){
     //获取回复人的名字
     var fhName = $(this).parents('.date-dz-right').parents('.date-dz').siblings('.pl-text').find('.comment-size-name').html();
     //回复@
     var fhN = '回复@'+fhName;
     //var oInput = $(this).parents('.date-dz-right').parents('.date-dz').siblings('.hf-con');
     var fhHtml = '<div class="hf-con pull-left"> <textarea class="content comment-input hf-input" placeholder="" onkeyup="keyUP(this)"></textarea> <a href="javascript:;" class="hf-pl">评论</a></div>';
     //显示回复
     if($(this).is('.hf-con-block')){
         $(this).parents('.date-dz-right').parents('.date-dz').append(fhHtml);
         $(this).removeClass('hf-con-block');
         $('.content').flexText();
         $(this).parents('.date-dz-right').siblings('.hf-con').find('.pre').css('padding','6px 15px');
         //console.log($(this).parents('.date-dz-right').siblings('.hf-con').find('.pre'))
         //input框自动聚焦
         $(this).parents('.date-dz-right').siblings('.hf-con').find('.hf-input').val('').focus().val(fhN);
     }else {
         $(this).addClass('hf-con-block');
         $(this).parents('.date-dz-right').siblings('.hf-con').remove();
     }
 });
 $('.commentAll').on('click','.removeBlock',function(){
     var oT = $(this).parents('.date-dz-right').parents('.date-dz').parents('.all-pl-con');
     if(oT.siblings('.all-pl-con').length >= 1){
         oT.remove();
     }else {
         $(this).parents('.date-dz-right').parents('.date-dz').parents('.all-pl-con').parents('.hf-list-con').css('display','none')
         oT.remove();
     }
     $(this).parents('.date-dz-right').parents('.date-dz').parents('.comment-show-con-list').parents('.comment-show-con').remove();

 })
 
  $('.comment-show').on('click','.date-dz-z',function(){
        var zNum = $(this).find('.z-num').html();
        if($(this).is('.date-dz-z-click')){
            zNum--;
            $(this).removeClass('date-dz-z-click red');
            $(this).find('.z-num').html(zNum);
            $(this).find('.date-dz-z-click-red').removeClass('red');
        }else {
            zNum++;
            $(this).addClass('date-dz-z-click');
            $(this).find('.z-num').html(zNum);
            $(this).find('.date-dz-z-click-red').addClass('red');
        }
    })
 
 