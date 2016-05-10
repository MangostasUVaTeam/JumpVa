(function (){

    var app = angular.module('login', []);


    app.controller("LoginController", function($scope,$location,$uibModalInstance,user, auth){

        var self = this;
        self.credentials = {};

        $scope.login = function(){

            user.login(self.credentials.email, self.credentials.password)
                .then(handleRequest, handleRequest);
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
            }
        };

        $scope.cancel = function(){
            $uibModalInstance.close('cancel');
        };

    });
})();
