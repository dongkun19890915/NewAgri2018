/**
 * Created by ZhangJiansen on 2017/3/20.
 * kindEditor 配置项说明 sample:$scope.config = {width: '100%',items:["image", "multiimage"]};
 *
 source：表示可以切换编辑器的编辑模式进入源代码HTML查看模式；
 undo：表示后退，也就是我们常用的CTRL+Z快捷键功能；
 redo：表示前进，也就是我们常用的CTRL+Y快捷键功能；
 preview：表示预览，点击可以提前预览编辑器内的内容所展示的效果。
 print：表示打印编辑器内的内容。
 template：表示可以插入编辑器内的模板窗体；
 code：表示可以插入代码段；
 cut：表示剪切；
 copy：表示复制，如同CTRL+C；
 paste：表示粘贴，如同CTRL+V；
 plainpaste：表示粘贴为无格式文本，主要是用于比如想赋值其他有HTML格式的纯文本进入编辑器，可以先在这里面进行HTML标签的过滤；
 wordpaste：表示从WORD内粘贴；
 justifyleft：表示选中文本居左；
 justifycenter：表示选中文本居中；
 justifyright：表示选中文本居右；
 justifyfull：表示两端对齐；
 insertorderedlist：表示编号（1、2、3）；
 insertunorderedlist：表示项目符号；
 indent：表示增加缩进；
 outdent：表示减少缩进；
 subscript：表示下标；如同：X2
 superscript：表示上标；如同：X2
 clearhtml：表示清除HTML标签；
 quickformat：表示快速排版；
 selectall：表示全选；
 fullscreen：表示全屏；
 formatblock：表示段落；
 fontname：表示字体；
 fontsize：表示文字大小；
 forecolor：表示文字颜色；
 hilitecolor：表示文字背景色；
 bold：表示文字加粗；
 italic：表示文字斜体；
 underline：表示给文字追加下划线；
 strikethrough：表示给文字追加删除线；
 lineheight：表示调整行距；
 removeformat：表示删除选中段的格式；
 image：表示单个上传图片；
 multiimage：表示批量上传图片；
 flash：表示插入flash；
 media：表示插入音视频文件；
 insertfile：表示插入文件；
 table：表示插入表格；
 hr：表示插入横线；
 emoticons：表示插入表情；
 baidumap：表示插入地图；
 pagebreak：表示插入分页符；
 anchor：表示插入锚点；
 link：表示插入超链接；
 unlink：表示取消超级链接；一般和link配合出现；
 about：表示关于kindeditor编辑器的信息；
 */
define(['angular','keditor','keditor-cn'],function(angular,keditor){
    'use strict';
    angular.module('sino.editor',[])
        .directive('sinoKindEditor',[
            function(){
                return {
                    restrict: 'AEC',
                    require: '^ngModel',
                    scope:{
                        editorConfig:'='
                    },
                    link:function(scope,element,attr,ctrl){
                        if(typeof window.KindEditor === 'undefined'){
                            throw new Error('KindEditor 资源文件未加载');
                        }
                        var editor;
                        var editorId = element[0];
                        //默认配置信息
                        var defConfig = {
                            width: '100%',
                            autoHeightMode: false,
                            afterCreate: function () {
                                this.loadPlugin('autoheight');
                            },
                            afterChange: function () {
                                var content = this.html();
                                if (editor) {
                                    scope.$evalAsync(function () {
                                        ctrl.$setViewValue(content);
                                    })
                                }
                            }
                        };

                        //加载个性化配置
                        var config = angular.extend(defConfig, scope.editorConfig);

                        //实例化编辑器
                        editor = new KindEditor.create(editorId, config);

                        //渲染处理
                        ctrl.$render = function(){
                            if(editor){
                                var content = ctrl.$isEmpty(ctrl.$viewValue) ? "":ctrl.$viewValue;
                                editor.html(content);
                            }
                        };
                    }
                }
            }
        ]);
});