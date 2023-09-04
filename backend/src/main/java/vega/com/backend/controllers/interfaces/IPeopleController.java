package vega.com.backend.controllers.interfaces;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vega.com.backend.dto.requests.PersonDTOForPatchReqst;
import vega.com.backend.dto.requests.PersonDTOReqst;
import vega.com.backend.dto.responses.PersonDTOResp;
import vega.com.backend.util.response.ResponseWithStatusAndDate;

public interface IPeopleController {

    @Operation(summary = "get user by principal")
    @GetMapping("/user")
    ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>>get(
            @AuthenticationPrincipal UserDetails userDetails
            );

    @Operation(summary = "get user by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "the user was received"),
            @ApiResponse(responseCode = "404",description = "the user was not found")
    })
    @GetMapping("/{id}")
    ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>> get(
            @Parameter(description = "user's ID") @PathVariable("id") int id);

    @Operation(summary = "get user's array")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "the users were received"),
            @ApiResponse(responseCode = "404",description = "the users were not found")
    })
    @GetMapping
    ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>> getAll();

    @Operation(summary = "get user's array with pagination")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "the users were received"),
            @ApiResponse(responseCode = "404",description = "the users were not found")
    })
    @GetMapping(params = {"page","size"})
    ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>>getAll(
            @Parameter(description = "number of page") @RequestParam("page")int page,
            @Parameter(description = "size of content") @RequestParam("size")int size);

    @Operation(summary = "get user's array with sorting")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "the users were received"),
            @ApiResponse(responseCode = "404",description = "the users were not found")
    })
    @GetMapping(params = {"field"})
    ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>>getAll(
            @Parameter(description = "field for sorting") @RequestParam("field")String fieldName);

    @Operation(summary = "get user's array with pagination and sorting")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "the users were received"),
            @ApiResponse(responseCode = "404",description = "the users were not found")
    })
    @GetMapping(params = {"field","page","size"})
    ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>>getAll(
            @Parameter(description = "number of page") @RequestParam("page")int page,
            @Parameter(description = "size of content") @RequestParam("size")int size,
            @Parameter(description = "field for sorting") @RequestParam("field")String fieldName);

    @Operation(summary = "get user's array with searching")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "the users were received"),
            @ApiResponse(responseCode = "404",description = "the users were not found")
    })
    @GetMapping(params = {"search"})
    ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>>getAllWhoseUsernameStaringWith(
            @Parameter(description = "field for searching") @RequestParam("search")String search);

    @Operation(summary = "create user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "the user was created"),
            @ApiResponse(responseCode = "400",description = "not valid fields (BAD REQUEST)")
    })
    @PostMapping
    ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>>create(
            @RequestBody @Valid PersonDTOReqst personDTOReqst, BindingResult bindingResult);

    @Operation(summary = "full user update")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "the user was updated"),
            @ApiResponse(responseCode = "400",description = "not valid fields (BAD REQUEST)"),
            @ApiResponse(responseCode = "404",description = "the users were not found")
    })
    @PutMapping("/{id}")
    ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>>updatePutMethod(
            @Parameter(description = "user's ID") @PathVariable("id") int id,
            @RequestBody @Valid PersonDTOReqst personDTOReqst, BindingResult bindingResult);

    @Operation(summary = "partial user update")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "the user was updated"),
            @ApiResponse(responseCode = "400",description = "not valid fields (BAD REQUEST)"),
            @ApiResponse(responseCode = "404",description = "the users were not found"),
            @ApiResponse(responseCode = "403",description = "attempt to change a forbidden field")
    })
    @PatchMapping("/{id}")
    ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>>updatePatchMethod(
            @Parameter(description = "user's ID") @PathVariable("id") int id,
            @RequestBody @Valid PersonDTOForPatchReqst personDTOForPatchReqst, BindingResult bindingResult);

    @Operation(summary = "delete user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "the user was deleted"),
            @ApiResponse(responseCode = "404",description = "the users were not found")
    })
    @DeleteMapping("/{id}")
    HttpStatus delete(
            @Parameter(description = "user's ID") @PathVariable("id") int id);
}
