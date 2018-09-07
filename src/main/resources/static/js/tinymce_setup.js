tinymce.init({
            selector: '#content',
            upload_image_url: './upload', //配置的上传图片的路由
            height: 600,
            width:800,
            language:'zh_CN',
            plugins: [
                'advlist autolink lists link  charmap print preview hr anchor pagebreak',
                'searchreplace wordcount visualblocks visualchars code fullscreen',
                'insertdatetime media nonbreaking save table contextmenu directionality',
                'emoticons template paste textcolor colorpicker textpattern imagetools codesample toc help uploadimage'
              ],
              toolbar1: 'undo redo | insert | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image',
              toolbar2: 'print preview media | forecolor backcolor emoticons | codesample help uploadimage',
              image_advtab: true,
              templates: [
                { title: 'Test template 1', content: 'Test 1' },
                { title: 'Test template 2', content: 'Test 2' }
              ],
            menubar: false
        });