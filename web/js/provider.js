(function (){

    var app = angular.module('provider', []);

    app.factory('authInterceptor', function (API, auth) {
        return {
            // automatically attach Authorization header
            request: function(config) {
                var token = auth.getToken();
                if(config.url.indexOf(API) === 0 && token) {
                    config.headers.Authorization = 'Bearer ' + token;
                }

                return config;
            },

            // If a token was sent back, save it
            response: function(res) {
                if(res.config.url.indexOf(API) === 0 && res.data.token) {
                    auth.saveToken(res.data.token);
                }

                return res;
            },
        };
    });

    app.constant('API', '/JumpVa/api');

    app.service('user', function userService($http, API, auth) {
        var self = this;
        self.role = auth.getRole();
        self.email = auth.getEmail();
        self.getQuote = function() {
            return $http.get(API + '/auth/quote');
        };

        self.getShipmentList = function() {
            console.log("get shipment list");
            return $http.get(API + '/shipment');
        };

        self.getUnassignedShipmentList = function(filters){
            console.log(filters);
            return $http.post(API + '/search-unassigned-shipment', filters);
        }

        self.postCreatedShipment = function(newShipment){
            console.log(newShipment);
            return $http.post(API + '/create-shipment', newShipment);
        }

        self.postNewUser = function(newUser){

            var response = $http.post(API + '/signin', newUser);

            response.then(function(responseData){

                auth.saveRole(newUser.role);;
                auth.saveEmail(newUser.credentials.email);
                self.role = auth.getRole();
                self.email = auth.getEmail();
            });

            return response;
        };

        self.postBidToUnassignedShipment = function(shipmentId, bid){
            var request = {'shipmentId': shipmentId, bid: bid};
            console.log(request);
            return $http.post(API + '/post-bid', request);
        };

        self.postNewHitoToShipment = function(shipmentId, milestone){
            milestone.carrier = self.email;
            var request = {'shipmentId': shipmentId, 'milestone': milestone};
            console.log(request);
            return $http.post(API + '/post-milestone', request);
        };

        self.login = function(credentials) {
            console.log(credentials);

            var response =  $http.post(API + '/authentication', credentials);
            response.then(function(responseData){
                auth.saveRole(responseData.data.role);;
                auth.saveEmail(responseData.data.email);
                self.role = auth.getRole();
                self.email = auth.getEmail();
            });

            return response;
        };

    });

    app.service('auth', function authService($window) {
        var self = this;
        self.parseJwt = function(token) {
            var base64Url = token.split('.')[1];
            var base64 = base64Url.replace('-', '+').replace('_', '/');
            return JSON.parse($window.atob(base64));
        };

        self.saveToken = function(token) {
            $window.localStorage['jwtToken'] = token;
        };

        self.getToken = function() {
            return $window.localStorage['jwtToken'];
        };

        self.saveEmail = function(token) {
            $window.localStorage['email'] = token;
        };

        self.getEmail = function() {
            return $window.localStorage['email'];
        };

        self.saveRole = function(token) {
            $window.localStorage['role'] = token;
        };

        self.getRole = function() {
            return $window.localStorage['role'];
        }

        self.isAuthed = function() {
            var token = self.getToken();
            if(token) {
                /*
                var params = self.parseJwt(token);
                return Math.round(new Date().getTime() / 1000) <= params.exp;
                */
                return true;
            } else {
                return false;
            }
        };

        self.logout = function() {
            $window.localStorage.removeItem('jwtToken');
            $window.localStorage.removeItem('email');
            $window.localStorage.removeItem('role');
        };
    });

})();
