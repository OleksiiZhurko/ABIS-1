$('#purpose').change(function() {
    const params = [0, 1, 2, 3];

    let newParams = [...params];
    let tempParams = ($('#params').val()).map(Number);

    for (let i = 0; i < tempParams.length; i++) {
        if (!tempParams.includes(params[i])) {
            tempParams.push(params[i]);
        }
        newParams[params.indexOf(tempParams[i])] = i;
    }

    $.ajax({
        url: window.location.origin + $(this).children("option:selected").val() + "&params=" + newParams,
    }).done(function(data) {
        let ctn = $("#content");
        ctn.empty();

        if (data.length === 0) {
            ctn.append('<p class="warning">Вибачте, нічого не знайдено</p>');
        } else {

            let str = '<div class="row">';

            for (let i = 0; i < data.length; i++) {
                str += "<div class='col-md-3'>\n" +
                    "                <div class='card my-3 text-center'>\n" +
                    "                    <img class='mx-auto d-block' alt='laptop' height='210px' src=" + data[i].imgUrl + " width='200px'>\n" +
                    "                    <h6 class='name px-1'>" + data[i].name + "</h6>\n" +
                    "                    <ul class='list-group list-group-flush spec'>\n" +
                    "                        <li class='list-group-item'></li>\n" +
                    "                        <li class='list-group-item'>" + data[i].characteristics.os + "</li>\n" +
                    "                        <li class='list-group-item'>" + data[i].characteristics.processorInfo + "</li>\n" +
                    "                        <li class='list-group-item'>" + data[i].characteristics.videoMemory + "</li>\n" +
                    "                        <li class='list-group-item'>" + data[i].characteristics.displayInfo + "</li>\n" +
                    "                        <li class='list-group-item'>" + data[i].characteristics.ram + "</li>\n" +
                    "                        <li class='list-group-item'>" + data[i].characteristics.rom + "</li>\n" +
                    "                        <li class='list-group-item price'>" + data[i].price + "$ </li>\n" +
                    "                    </ul>\n" +
                    "                    <button class='btn btn-dark my-2 mx-5' onclick='location.href=\"" + data[i].urlTo + "\"' type='submit'>\n" +
                    "                        Детальніше\n" +
                    "                    </button>\n" +
                    "                </div>\n" +
                    "            </div>";
            }

            ctn.append(str + '</div>');
        }
    });
});