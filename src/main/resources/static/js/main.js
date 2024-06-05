$(function(){

    const appendparcel = function(data){
        var parcelCode = '<a href="#" class="parcel-link" data-id="' +
            data.id + '">' + data.numcadastr + '</a><br>';
        $('#parcel-list')
            .append('<div>' + parcelCode + '</div>');
    };

    //Loading books on load page
//    $.get('/books/', function(response)
//    {
//        for(i in response) {
//            appendBook(response[i]);
//        }
//    });

    //Show adding book form
    $('#show-add-parcel-form').click(function(){
        $('#parcel-form').css('display', 'flex');
    });

    //Closing adding book form
    $('#book-form').click(function(event){
        if(event.target === this) {
            $(this).css('display', 'none');
        }
    });

    //Getting book
    $(document).on('click', '.parcel-link', function(){
        var link = $(this);
        var bookId = link.data('id');
        $.ajax({
            method: "GET",
            url: '/parcels/' + bookId,
            success: function(response)
            {
                var code = '<span>Год выпуска____:' + response.year + '</span>';
                link.parent().append(code);
            },
            error: function(response)
            {
                if(response.status == 404) {
                    alert('Книга&&&&&& не найдена!');
                }
            }
        });
        return false;
    });

    //Adding book
    $('#save-parcel').click(function()
    {
        var data = $('#parcel-form form').serialize();

        alert ("data");
        alert (data);



        $.ajax({
            method: "POST",
            url: '/parcels/',
            data: data,
            success: function(response)
            {
                $('#parcel-form').css('display', 'none');
                var parcel = {};
                parcel.id = response;
                var dataArray = $('#parcel-form form').serializeArray();
                for(i in dataArray) {
                    parcel[dataArray[i]['id']] = dataArray[i]['numcadastr'];
                }
                appendparcel(parcel);
            }
        });
        return false;
    });

});