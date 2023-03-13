<html>
<head>

    <title>Weather App</title>

    <link href = "${pageContext.request.contextPath}/resource/lib/bootstrap.min.css" rel="stylesheet">
    <link href = "${pageContext.request.contextPath}/resource/main.css" rel="stylesheet">

    <script src= "${pageContext.request.contextPath}/resource/lib/jquery.min.js"></script>
    <script src= "${pageContext.request.contextPath}/resource/lib/sockjs.min.js"></script>
    <script src= "${pageContext.request.contextPath}/resource/lib/stomp.min.js"></script>

    <script src= "${pageContext.request.contextPath}/resource/app.js"></script>

    <script type="text/javascript">
        window.onload = connect;
    </script>

</head>

<body>

<div id="main-content" class="container">

    <div class="row">
        <div class="col-md-12">
                <div class="row">
                    <h1>Weather Assessment</h1>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <div class = "form-inline">
                            <h5>Current City: ${cityName} </h5>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-inline">
                            <h5>Current Temperature: ${LatestTemperature}</h5>
                        </div>
                    </div>
                </div>
            <hr>
        </div>

    </div>

    <div class="row">

        <div class="col-md-9">
            <h5>Please provide details for notifications: </h5>
            <br>
        </div>

        <div class="col-md-12">
            <div class="form-inline">
                <div class="form-group">
                    <div class="row">
                            <div class="col-md-4">
                                <label for="name">What value of minimum temperature you want to be notified?</label>
                                <input type="number" id="name" class="form-control" placeholder="Enter Value">
                            </div>

                            <div class="col-md-4">
                                <label for="value">What value of maximum temperature you want to be notified?</label>
                                <input type="number" id="value" class="form-control" placeholder="enter value">
                            </div>
                            <div class="col-md-4">
                                <button id="send" class="btn btn-default" type="submit" style="margin-bottom: 20px">Send</button>
                            </div>
                    </div>
                </div>
                <div class="row">
                    <small>You'll be notified when the temperature goes above maximum value, or below the minimum value.</small>
                    <br>
                </div>
            </div>
        </div>
    </div>


    <div class="row">
        <div class="col-md-12">
            <table id="conversation" class="table table-striped">
                <thead>
                <tr>
                    <th>System Notifications</th>
                </tr>
                </thead>
                <tbody id="greetings"></tbody>
            </table>
        </div>
    </div>

</div>

</body>
</html>
