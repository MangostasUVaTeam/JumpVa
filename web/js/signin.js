(function (){

    var app = angular.module('signin', ['jumpva']);


    app.controller("SigninController", function($scope,$location,$uibModalInstance, user){

        var self = this;
        self.newUser = {};

        self.cancel = function(){
            $uibModalInstance.close('cancel');
        };

        self.createAccount = function(){
            //$location.path('/main');
            //$uibModalInstance.close('main');
            if (self.carrier){
                self.newUser.role = "TRANSPORTISTA";
            } else {
                self.newUser.role = "CLIENTE";

            }
            user.postNewUser(self.newUser)
                .then(handleRequest);;
        };

        function handleRequest(res) {
            $location.path('/main');
            $uibModalInstance.close('main');
        };
    });
})();
