layui.define(["layer"], function (exports) {
  var layer = layui.layer;
  var obj = {
    rightPopupLayer: function (content = "") {
      layer.open({
        type: 1,
        title: "",
        // offset: ["10px", "100%"],
        skin: "layui-anim layui-anim-rl layui-layer-adminRight",
        closeBtn: 0,
        content: content,
        shadeClose: true,
        // area: ['16%', '95%']
      });
      let op_width = $(".layui-anim-rl").outerWidth();
      $(".layui-layer-shade")
        .off("click")
        .on("click", function () {
          $(".layui-anim-rl").animate(
            { left: "+=" + op_width + "px" },
            300,
            "linear",
            function () {
              $(".layui-anim-rl").remove();
              $(".layui-layer-shade").remove();
            }
          );
        });
    },
  };
  exports("rightPopup", obj);
});
