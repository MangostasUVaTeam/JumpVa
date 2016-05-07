(function (){

    var app = angular.module('provider', []);

    app.constant('rootPath', 'api/');

    app.service('loginRequest', function($http) {
        delete $http.defaults.headers.common['X-Requested-With'];
        this.getData = function(callbackFunc) {
            $http({
                method: 'GET',
                url: 'api/helloworld',
                headers: {'Authorization': 'Bearer token=xxxxYYYYZzzz'}
             }).success(function(data){
                // With the data succesfully returned, call our callback
                callbackFunc(data);
            }).error(function(){
                alert("error");
            });
        }
    });
})();
