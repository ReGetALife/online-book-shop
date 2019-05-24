layui.use('element', function(){
    var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
    
    //监听导航点击
    element.on('nav(demo)', function(elem){
      //console.log(elem)
      layer.msg(elem.text());
    });
  });

  layui.use('form', function(){
    var form = layui.form;
    
    //各种基于事件的操作，下面会有进一步介绍
  });

  layui.use('carousel', function(){
    var carousel = layui.carousel;
    //建造实例
    carousel.render({
      elem: '#scroll'
      ,width: '100%' //设置容器宽度
      ,arrow: 'always' //始终显示箭头
      //,anim: 'updown' //切换动画方式
    });
  });

  layui.use('carousel', function(){
    var carousel = layui.carousel;
    //建造实例
    carousel.render({
      elem: '#new-book'
      ,width: '100%' //设置容器宽度
      ,height: '380px'
      ,arrow: 'hover' //始终显示箭头
      ,autoplay: false
    });
  });
  layui.use('carousel', function(){
    var carousel = layui.carousel;
    //建造实例
    carousel.render({
      elem: '#hot-book'
      ,width: '100%' //设置容器宽度
      ,height: '380px'
      ,arrow: 'hover' //始终显示箭头
      ,autoplay: false
    });
  });