(function (){

    var app = angular.module('login', []);


    app.controller("LoginController", function($scope,$location,$uibModalInstance,user, auth){

        var self = this;
        self.credentials = {};

        self.login = function(){
            console.log(self.credentials);

            if($scope.loginForm.$valid){
                user.login(self.credentials)
                    .then(handleRequest, handleRequest);
            }
        };

        function handleRequest(res) {
            var token = res.data ? res.data.token : null;

            if(token) {
                console.log('JWT:', token);
            };
            self.message = res.data.message;

            if (auth.isAuthed()){
                $location.path('/main');
                $uibModalInstance.close('main');
            } else {
                self.showAlert = true;
            }
        };

        self.cancel = function(){
            $uibModalInstance.close('cancel');
        };

    });
})();
