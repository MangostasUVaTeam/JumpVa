(function (){

    var app = angular.module('provider', []);

    app.constant('rootPath', 'http://localhost:8080/JumpVa/');

    app.service('apiRequest', function($http, rootPath) {
        delete $http.defaults.headers.common['X-Requested-With'];

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
        };

        this.setData = function(user, callbackFunc) {
            $http({
                method: 'POST',
                url: 'api/authentication',
                data: user
             }).success(function(data){
                // With the data succesfully returned, call our callback
                callbackFunc(data);
            }).error(function(){
                alert("error");
            });
        };

        this.authenticate = function(credentials, callbackFunc, errorFunc) {
            $http({
                method: 'POST',
                url: rootPath + 'api/authentication',
                data: credentials
             }).success(function(data){
                // With the data succesfully returned, call our callback
                callbackFunc(data);
            }).error(function(){
                alert("error");
            });
        };
    });
})();
